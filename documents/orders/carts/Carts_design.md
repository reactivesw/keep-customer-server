# Cart service design
This micro-service provide services for handle cart requirements, such as create cart, merge cart, change cart etc.

# 1. DataBase

---|---|---
TableName                   |Type                   |Description
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






