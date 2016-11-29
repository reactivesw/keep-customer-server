# Cart service design
This micro-service provide services for handle cart requirements, such as create cart, merge cart, change cart etc.
And cart should keep an snapshot of the product that added to it.

# 1. DataBase
TableName                   |Type                   |Description
|---|---|---
CartEntity                  |Entity Object          |The cart, hold all info of the cart.
AddressValue                |Value Object           |The address used in cart, include shipping address and the billing address.
ShippingInfoValue           |Value Object           |The shipping info of the cart.
ShippingRateValue           |Value Object           |Shipping rate, apart of shipping info.
PaymentInfoValue            |Value Object           |The payment info of this cart.
TaxedPriceValue             |Value Object           |The taxed price of the cart.
TaxPortionValue             |Value Object           |The tax portion, apart of taxed price.
LineItemValue               |Value Object           |The snapshot of the product added to the cart
ProductVariantValue         |Value Object           |The snapshot of the product variant that added to the cart.
PriceValue                  |Value Object           |Price used in product variant. apart of the product snapshot.
AttributeValue              |Value Object           |Attribute of the product variant, apart of the product snapshot.
ImageValue                  |Value OBject           |Image used in product variant, apart of the product snapshot.
CustomLineItemValue         |Value Object           |The snapshot of the custom Item.
ItemStateValue              |Value Object           |The Item state.
TaxedItemPriceValue         |Value Object           |Taxed Item Price used in Item.
TaxRateValue                |Value Object           |Tax Rate, used in Item for record tax rate.
SubRateValue                |Value Object           |Sub Rate of tax rate.

# 2. CartState
`Active` : only cart in this state can be update.
`Merged` : this state means the cart is create by an anonymous customer, and be merged to a customer's cart. Cart in this state can not been changed.
`Ordered`: this state means the cart had been checked out. Cart in this state can not been changed.

# 3. Business logic

## 3.1 Get cart
Get a cart by some conditions.

### 3.1.1 Get cart by cart id
Get a cart by the cart ID, and return the cart.

### 3.1.2 Get cart by customer id
Get a cart by the customer's id, return the one that has been modified most recently, and the cart's state should be `Active`.
Each customer should has only one cart that is active.

## 3.2 Query cart
System can Use `where`,`sort`,`expand`,`limit`,`offset` to query carts.

## 3.3 Create cart
When the customer `add a product to cart`, and there is no cart in `Active` state, the system auto create a new cart for the customer.
 
## 3.4 Update cart
Use update actions to update an existing cart.

### 3.4.1 Merge cart
Merge cart from anonymous customer to an registered customer, and no further operations on the cart are allowed.

### 3.4.2 Checkout
Checkout a cart, the cart's state will be set as `Ordered`, and no further operations on the cart are allowed.





