# Catalog 设计——Category

## 1. 数据库
catalog_category

## 2. 业务流程
### 2.1 添加

添加Category对外界没有影响，直接添加，version自动生成为0，ID为自动生成的UUID。

添加subCategory，需要设置parent和ancestors列表，ancestors列表由parent计算出来。

在同一节点下的Category名字不能重复，任何语言都不能重复。

orderHint使用String类型，内容为大于等于0的Integer，初始值为0，数字越大表示优先级越高，如果相同，则由创建时间先后决定，时间越早越优先。

### 2.2 查询
#### 2.2.1 根据ID查询
#### 2.2.2 根据条件查询

查询参数包括：

1. where
  
  查询谓词，支持的属性包括：
  
  name,slug,version,createdAt,lastModifiedAt
  
  例子：name(en="Pro T-Shirt") and version > 12 and createdAt > "2016-11-08T07:10:58.000Z"
  
2. sort
  
  排序谓词，支持的属性包括：
  
  name,slug,version,createdAt,lastModifiedAt
  
  注意：对name，slug这种LocalizedString，需要指定具体的语言，比如name.en
  
3. expand

4. limit
  
  Integer, 每页的数目
  
5. offset
  
  Integer，第几页

### 2.3 修改

Category的修改不会影响外部信息，可以直接修改。

所有的修改操作，都需要与当前的version一致，否则失败。

提供了以下UpdateAction：

1. Change Name
2. Change Slug
3. Set Description
4. Change Parent

  修改Parent的同时，需要修改对应的ancestors列表。

5. Change OrderHint
6. Set External ID
7. Set Meta Title
8. Set Meta Description
9. Set Meta Keywords
10. Set Custom Type
11. Set CustomField

### 2.4 删除

根据ID来删除Category，需要做以下操作：

1. 如果有subCategory，需要删除所有的subCategory
2. 如果有产品的关联关系，需要删除所有关联关系（subCategory同样操作）

## 3. message

操作Category会产生以下message

1. 添加Category时，需要发送新增Category的message
2. 修改 //TODO 哪些情况需要发送message？？？
3. 删除，需要发送删除Category的message

## 4. API定义

API定义参照[CommerceTools](https://dev.commercetools.com/http-api-projects-categories.html)

### 4.1 Get Category by ID

url: /categories/{id}

Method: GET

Response Representation: Category

exception:

1. can not find Category by the id, return http status 404

### 4.2 Query Categories

url: /categories

Method: GET

Response Representation: PagedQueryResult with the results array of Category

Query Parameters: QueryConditions with following parameters
* where - Predicate - Optional
* sort - Sort - Optional
* expand - Expansion - Optional
* limit - Number - Optional
* offset - Number - Optional

exception: 

1. when parameters is invalid, return http status 400

### 4.3 Create a Category
url: /categories

Method: POST

Request Representation: CategoryDraft

Response Representation: Category

exception:
1. when parameters is invalid, return http status 400

### 4.4 Update Category

url: /categories/{id}

Method: PUT

Request Representation: Fields with version and update action list

Response Representation: Category

exception:

1. when parameters is invalid, return http status 400

### 4.5 Delete Category

url: /categories/{id}

Method: DELETE

Query Parameters:

* version - Number - Required

exception:

1. can not find Category by the id, return http status 404
2. when version is not match , return http status 400