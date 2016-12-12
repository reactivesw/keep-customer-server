# Catalog设计——TaxCategory

## 1. 数据库
catalog_tax_category
catalog_tax_category_rate
catalog_tax_category_sub_rate

## 2. 业务流程
### 2.1 添加

添加TaxCategory对外界没有影响，直接添加，设置version为1，ID为自动生成的UUID。

TaxCategory的名字不可以重复。

可以一同添加TaxRate，也可以在修改中添加TaxTate。

### 2.2 查询
#### 2.2.1 根据ID查询
#### 2.2.2  根据条件查询

查询参数包括：

1. where

  查询谓词，支持的属性包括：

  name,version,createdAt,lastModifiedAt

  例子：name(en="Pro T-Shirt") and createdAt > "2016-11-08T07:10:58.000Z"

2. sort

  排序谓词，支持的属性包括：

  name,version,createdAt,lastModifiedAt

  例子：name.en asc

3. expand

4. limit

  Integer, 每页的数目

5. offset

  Integer，第几页

### 2.3 修改

TaxCategory的修改不会影响外部信息，可以直接修改。

所有的修改操作，都需要与当前的version一致，否则失败。

提供了以下UpdateAction：

1. Change Name
    不能与现有名字重复
2. Set Description
3. Add TaxRate
    需要判断税率的值是否在[0,1],以及一个TaxCategory只能有同一个Country和state，不能重复
4. Replace TaxRate
5. Remove TaxRate
    直接删除即可

### 2.4 删除

根据ID和version来删除TaxCategory，需要做以下操作：

1. 如果有产品的关联关系，则不可以直接删除TaxCategory，必须要在产品信息中去除该TaxCategory才可以删除

## 3. message

操作TaxCategory会产生以下message

1. 添加TaxCategory时，需要发送新增TaxCategory的message
2. 修改 //TODO 哪些情况需要发送message？？？
3. 删除，需要发送删除TaxCategory的message

## 4. API定义

API定义参照[CommerceTools](https://dev.commercetools.com/http-api-projects-categories.html)

### 4.1 Get TaxCategory by ID

url: /tax-categories/{id}

Method: GET

Response Representation: TaxCategory

exception:

1. can not find TaxCategory by the id, return http status 404


### 4.2 Query TaxCategory

url: /tax-categories

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

### 4.3 Create a TaxCategory
url: /tax-categories

Method: POST

Request Representation: TaxCategoryDraft

Response Representation: TaxCategory

exception:
1. when parameters is invalid, return http status 400

### 4.4 Update Category

url: /tax-categories/{id}

Method: POST

Request Representation: Fields with version and update action list

Response Representation: Category

exception:

1. when parameters is invalid, return http status 400

### 4.5 Delete Category

url: /tax-categories/{id}

Method: DELETE

Query Parameters:

* version - Number - Required

exception:

1. can not find TaxCategory by the id, return http status 404
2. when version is not match , return http status 400