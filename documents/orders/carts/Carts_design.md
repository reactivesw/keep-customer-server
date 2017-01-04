# Cart service design
This micro-service provide services for handle cart requirements, such as create cart, merge cart, change cart etc.

***Key Points:***

- Each customer can and can only has one cart, if the cart not exist, the the system will create a new one for the customer.

- Cart only keep the basic ids of the data that related to. Such as product id, variant id, customer id, shipping method id. 

- Every time we got a cart, the system will gather the data from other service, if the data(like a product) dose not exist any more, the system will delete the data id in the cart.

- After gather data, the system will calculate the price of the cart automatic.

- `TaxRate` only depend on `ShippingAddress`, once the `ShippingAddress` been set, then the `TaxRate` of the `LineItem` and `ShippingMethod` will be set automatically.
 
- `TaxMode` for now we only support Platform TaxMode, it means the tax will be calculate by the platform automatically.

- When we calculate `TaxedPrice`, we use `Math.round`, it means, 1.4 or less -> 1, 1.5 and bigger -> 2,


***Cart Price Calculator:***
Cart price contains two kind: `Total Price`, `Taxed Price`

- **Total Price:** 
The sum of all totalPrice fields of the lineItems, and the price field of shippingInfo (if it exists). TotalPrice may or may not include the taxes: it depends on the taxRate.includedInPrice property of each price.

- **Taxed Price:** 
The sum of all TaxedPrice fields of the lineItems, and the TaxedPrice field of shipping info(if it exists). Not set until the shipping address is set. Will be set automatically.

***LineItem Price Calculator***
LineItem Price contain two kind: `Total Price`, `Taxed Price`

- **LineItem Total Price:** 
Product price multiplied by the quantity. TotalPrice may or may not include the taxes: it depends on the taxRate.includedInPrice

- **Taxed Item Price:**
`Taxed Item Price` will be set once the `TaxRate` be set. And the TaxedItemPrice is the TotalPrice that include taxes.
 
***Shipping Price Calculator***
 Shipping Price depend on these factors: `ShippingMethod`, `ShippingAddress`, `LineItemTotalPrice`
 `ShippingMethod` and `ShippingAddress` will define how much money that should cost.
 `LineItemTotalPrice` may make the shipping free if it above some bar. Use `FreeAbove` attribute in `ShippingRate`
 
- **Price** 
Determined based on the `ShippingRate`, that selected use `ShippingMethod` & `ShippingAddress`, and the sum of LineItem prices.

- **TaxedPrice**
This will be set once the `TaxRate` be set


# 1. DataBase
TableName                   |Type                   |Description
|---|---|---
CartEntity                  |Entity Object          |The cart, hold all info of the cart.
ShippingInfoValue           |Value Object           |The shipping info of the cart.
LineItemValue               |Value Object           |The snapshot of the product added to the cart

# 2. CartState
`Active` : only cart in this state can be update.
`Merged` : this state means the cart is create by an anonymous customer, and be merged to a customer's cart. Cart in this state can not been changed.
`Ordered`: this state means the cart had been checked out. Cart in this state can not been changed.

# 3. Business logic

## 3.1 Get cart
Get a cart by some conditions.


### 3.1.1 Get cart by cart id
Get a cart by the cart ID, and return the cart.
- 

### 3.1.2 Get cart by customer id
Get a cart by the customer's id, return the one that has been modified most recently, and the cart's state should be `Active`.
Each customer should has only one cart that is active.

### 3.1.3 Get cart by anonymous id
Get a cart by the anonymous id, one anonymous id can only has one cart.

## 3.2 Query cart
TODO
System can Use `where`,`sort`,`expand`,`limit`,`offset` to query carts.

## 3.3 Create cart
When the customer `add a product to cart`, and there is no cart in `Active` state, the system auto create a new cart for the customer.
 
## 3.4 Update cart
Use update actions to update an existing cart.

### 3.4.1 Merge cart
Merge cart from anonymous customer to an registered customer, and no further operations on the cart are allowed.

### 3.4.2 Checkout
Checkout a cart, the cart's state will be set as `Ordered`, and no further operations on the cart are allowed.





