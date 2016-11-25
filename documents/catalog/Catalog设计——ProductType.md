# Catalog设计——ProductType

## 1. 数据库
catalog_product_type
catalog_product_attribute

## 2. 业务流程
### 2.1 添加
添加ProductType对外界没有影响，直接添加，设置version为1，ID为自动生成的UUID。
ProductType的名字可以重复。
可以一同添加attribute，也可以在修改中添加attribute。

### 2.2 查询
#### 2.2.1 根据ID查询
#### 2.2.2 根据key查询
#### 2.2.3 根据条件查询
查询参数包括：
1. where
  查询谓词，支持的属性包括：
  name,slug,version,createdAt,lastModifiedAt
  例子：name(en="Pro T-Shirt") and version > 12 and createdAt > "2016-11-08T07:10:58.000Z"
2. sort
  排序谓词，支持的属性包括：
  name,slug,version,createdAt,lastModifiedAt
  例子：name.en asc
  注意：对name，slug这种LocalizedString，需要指定具体的语言，比如name.en
3. expand
4. limit
  Integer, 每页的数目
5. offset
  Integer，第几页

### 2.3 修改
对ProductType的修改，有两种途径，一种是根据ID来修改，一种是根据Key来修改
根据ID来修改的URL为：`/product-types/{id}`
根据Key来修改的URL为：`/product-types/key={key}`
所有的修改操作，都需要与当前的version一致，否则失败。
提供了以下UpdateAction：
1. Set Key
2. Change Name
3. Change Description
4. Add AttributeDefinition
5. Remove AttributeDefinition
6. Change AttributeDefinition Label
7. Set AttributeDefinition InputTip
8. Add PlainEnumValue to AttributeDefinition
9. Add LocalizableEnumValue to AttributeDefinition
10. Change the order of AttributeDefinitions
11. Change the order of EnumValues
12. Change the order of LocalizedEnumValues
13. Change the label of an EnumValue
14. Change the label of a LocalizedEnumValue
15. Change AttributeDefinition IsSearchable

### 2.4 删除
对ProductType的删除，有两种途径，一种是根据ID来删除，一种是根据Key来删除
根据ID来删除的URL为：`/product-types/{id}`
根据Key来删除的URL为：`/product-types/key={key}`
不允许删除与Product有关联关系的ProductType。

### 3.message
操作ProductType会产生以下message
1. 添加ProductType时，需要发送新增ProductType的message
2. 对以下修改动作发送message：//TODO 哪些情况需要发送message
  * Add AttributeDefinition
  * Remove AttributeDefinition
  * Add PlainEnumValue to AttributeDefinition
  * Add LocalizableEnumValue to AttributeDefinition
3. 删除，需要发送删除ProductType的message

### 4. API 定义
API定义参照[CommerctTools](https://dev.commercetools.com/http-api-projects-productTypes.html)