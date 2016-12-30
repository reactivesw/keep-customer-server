# Category Design

## 1. create Category

### 1.1 workflow

1. set `parentId` and `ancestors`. 
    
    `ancestors` is a list of string, contains the parent path towards the root category, like [ parent `Category`'s `ancestors` + `parentId` ].if `parent` is null , `ancestors` is null list 

2. validate name with same root categories 
    
    name is a `LocalizedString`, The categories that belong to the same direct root, should have unique name. And `Unique name` means combination of language and text is unique.

3. save `Category`
4. update cache
5. send a message //TODO

### 1.2 exception
occurrence | exception | http code
-|-|-|-
`parent CategoryEntity` is null | `NotExistException` | 404
same name in same root `CategoryEntity` | `AlreadyExistException` | 409
`slug` is exist | `AlreadyExistException` | 409

## 2. delete Category

### 2.1 workflow

1. validate version
2. delete category and it's subCategory
3. update cache
4. send a message //TODO

    for `Product` service, should cache this message and removed all the relitionships from all those products that had that category assigned in their ProductData.

### 2.2 exception
occurrence | exception | http code
-|-|-|-
version not match | `ConflictException` | 409
can not find category | `NotExistException` | 404

## 3. update Category

### 3.1 workflow

1. validate version
2. update category by different update actions
3. update cache
4. send a message //TODO

### 3.2 update action

1. Set Name
   * `action` - String - "setName"
   * `name` - LocalizedString - Required

2. Set Slug
   * `action` - String - "setSlug"
   * `slug` - String - Required
      
      Allowed are alphabetic, numeric, underscore (_) and hyphen (-) characters. Maximum size is 256.

3. Set Description
   * `action` - String - "setDescription"
   * `description` - LocalizedString - Required

4. Set Parent
   * `action` - String - "setParent"
   * `parent` - Reference to a Category - Required

   change parent should change ancestors and subCategory's ancestors

5. Set OrderHint
   * `action` - String - "setOrderHint"
   * `orderHint` - String - Required

6. Set External ID
   
   Sets a new ID which can be used as additional identifier for external Systems like CRM or ERP.
   
   * `action` - String - "setExternalId"  
   * `externalId` - String - Optional

     If not defined, the external ID is unset.

7. Set Meta Title
   * `action` - String - "setMetaTitle"
   * `metaTitle` - LocalizedString - Optional

     If not defined, the metaTitle is unset.

8. Set Meta Description
   * `action` - String - "setMetaDescription"
   * `metaDescription` - LocalizedString - Optional

     If not defined, the metaDescription is unset.

9. Set Meta Keywords
   * `action` - String - "setMetaKeywords"
   * `metaDescription` - LocalizedString - Optional
     
     If not defined, the metaDescription is unset.

10. Set Custom Type
    //TODO

11. Set CustomField
    //TODO

### 3.3 exception
occurrence | exception | http code
-|-|-|-
version not match | `ConflictException` | 409
can not find category | `NotExistException` | 404

## 4. query Category by id

### 4.1 workflow

1. query category by id

### 4.2 exception
occurrence | exception | http code
-|-|-|-
can not find category | `NotExistException` | 404

## 5. query category by query conditions

NOTE: for now, just query all categories
