# Bug Report: Item in cart is available with every user.

**Reported By:** Tavirutyutyu  
**Date:** 2024/09/19

## Environment:
- **OS:** Windows 11
- **Java Version:** 22
- **JUnit Version:** 5
- **Selenium Version:** 4.23.0
- **Browser:** Chrome Version 128.0.6613.138

## Description:
If the user puts an item to the cart and then logs out, 
the next user who logs in will see the logged out user's cart.

## Steps to Reproduce:
1. Open main page, log in and put an item to the cart, and than log out.
2. Log in with another user.
3. Click on the cart.

## Expected Result:
- The cart is either empty or only contains the current user's items.

## Actual Result:
- The cart contains previous user's items.



