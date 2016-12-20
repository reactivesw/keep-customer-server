#Product Design

## 1. database tables
catalog_product
catalog_product_catalog_data
catalog_product_data
catalog_product_variant
catalog_product_price
catalog_product_attribute
catalog_product_image

## 2. workflow

### 2.1 create Product

新增Product对外界没有影响，可以直接添加，version自动生成为0，ID为自动生成的UUID字符串。

新增masterVariant, id为1

获取ProductType以及对应的Attribute,根据获取到的信息填充Product的数据

如果包含Category的信息,需要建立关联关系

在新增Product的过程中，需要校验以下问题：

1. name, slug, productType是必填属性
2. productType的id是否存在，如果不存在则失败
3. 如果taxCategory不为空，则需要校验taxCategory是否存在
4. 如果state不为空，则需要校验state是否存在
5. 如果Category不为空,则需要校验Category是否存在

### 2.2 delete Product

### 2.3 update Product

### 2.4 query Product

## 3. message

1. add product, should create a message about `ProductCreated`

2. update product, should create a message about `ProductUpdated`

3. delete product, should create a message about `ProductDeleted`

## 4. API Definition

### 4.1 create Product

url : /products

Method : POST

Request Representation: ProductDraft

Response Representation: Product

exception:

1. 

### 4.2 delete Product

url: /products/{id}

Method: DELETE

Query Parameters:

* version - Number - Required

exception:

1. can not find product by the id, return http status 404
2. when version is not match, return http status 400

### 4.3 update Product

url: /products/{id}

Method: PUT

Request Representation: Fields with version and updata action list

Response Representation: Product

exception:

1. can not find product by the id, return http status 404
2. when version is not match, return http status 400

### 4.4 get Product by id

url: /products/{id}

Method: GET

Request Representation: null

Response Representation: Product

exception:

1. can not find product by the id, return http status 404

### 4.5 query Products

url: /products

Method: GET

Request Representation: QueryConditions

Response Representation: PagedQueryResult<Product>

exception:

1. 