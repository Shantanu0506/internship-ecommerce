# 🛒 Vibgyor E-Commerce Platform  
A complete e-commerce backend system built using **Spring Boot, Spring Data JPA, and MySQL**.  
This project includes every major module required for a real-world e-commerce platform.

---

## 🚀 Features / Modules

### 1️⃣ Admin Module
- Admin login  
- Manage categories  
- Manage products  
- Manage orders  
- Manage shipping  
- Manage coupons  
- Review moderation  
- Customer management

---

## 2️⃣ Category Management
The Category module manages product categories for organizing the store.

### ✔ Functionalities
- Add new category  
- Update category  
- Delete / Soft delete category  
- Activate / Deactivate category  
- View all categories  

### ✔ Table (categories)
| Column | Type | Description |
|--------|------|-------------|
| category_id | PK | Unique ID |
| category_name | varchar | Category name |
| active | boolean | Status |
| created_at | datetime | Created date |
| updated_at | datetime | Updated date |

---

## 3️⃣ Product Management
This module manages all products listed on the website.

### ✔ Functionalities
- Add product  
- Edit product  
- Delete product  
- Product activation  
- Manage stock  
- SKU management  
- Inventory tracking  
- Product dashboard  

### ✔ Table (products)
| Column | Type | Description |
|-------|-------|-------------|
| product_id | PK | Unique ID |
| name | varchar | Product name |
| description | text | Details |
| price | decimal | Product price |
| sku | varchar | Unique SKU |
| stock | int | Inventory count |
| category_id | FK | Category reference |
| active | boolean | Status |

---

## 4️⃣ Customer Management
Allows admin to manage registered customers.

### ✔ Functionalities
- Add customer  
- Update customer  
- Delete customer  
- Customer list  
- Customer dashboard  

### ✔ Table (users/customers)
Contains customer details like name, email, mobile, and address.

---

## 5️⃣ Order Management
Handles customer orders and admin processing.

### ✔ Functionalities
- Place order  
- View orders  
- Update order status (Pending, Confirmed, Shipped, Delivered)  
- Cancel order  
- Order dashboard  
- Order summary  

### ✔ Table (orders)
| Column | Type | Description |
|--------|------|-------------|
| order_id | PK | Unique ID |
| customer_id | FK | Who placed the order |
| total_amount | decimal | Final amount |
| status | varchar | Order status |
| created_at | datetime | Date |

---

## 6️⃣ Payment Management
Processes payments for customer orders.

### ✔ Functionalities
- Payment initiation  
- Save payment details  
- View payment status  
- Payment dashboard  

### ✔ Table (payments)
| Column | Type | Description |
|--------|------|-------------|
| payment_id | PK | Unique ID |
| order_id | FK | Payment belongs to |
| amount | decimal | Paid amount |
| method | varchar | COD / UPI / Card |
| status | varchar | Paid / Pending / Failed |

---

## 7️⃣ Cart Management
Allows customers to add items into their temporary shopping cart.

### ✔ Functionalities
- Add product to cart  
- Update quantity  
- Remove from cart  
- Auto-price calculation  
- Cart dashboard  

### ✔ Table (carts)
| Column | Type | Description |
|--------|------|-------------|
| cart_id | PK | Unique cart id |
| customer_id | FK | Customer |
| product_id | FK | Product |
| quantity | int | Items |
| total_price | decimal | Auto calculated |

---

## 8️⃣ Wishlist Management
Customers can save products they want to buy later.

### ✔ Functionalities
- Add to wishlist  
- View wishlist  
- Remove wishlist item  
- Move to cart  

### ✔ Table (wishlists)
| Column | Type | Description |
|--------|------|-------------|
| wishlist_id | PK |
| customer_id | FK |
| product_id | FK |
| created_at | datetime |

---

## 9️⃣ Shipping Management
Handles order shipping and logistics.

### ✔ Functionalities
- Calculate shipping cost  
- Assign courier service  
- Add tracking number  
- Shipping dashboard  
- Update shipping status  
- Track shipment  

### ✔ Table (shipping)
| Column | Type | Description |
|--------|------|-------------|
| shipping_id | PK |
| order_id | FK |
| courier_service | varchar |
| tracking_number | varchar |
| shipping_status | varchar (Shipped, In Transit, Delivered) |
| shipping_cost | decimal |

---

## 🔟 Review & Rating Management
Allows customers to provide feedback for products.

### ✔ Functionalities
- Add review  
- Give rating (1–5)  
- Review approval by admin  
- Delete/Update review  
- Show product-wise reviews  

### ✔ Table (reviews)
| Column | Type | Description |
|--------|------|-------------|
| review_id | PK |
| product_id | FK |
| customer_id | FK |
| rating | int |
| review_text | varchar |
| status | boolean (approved/unapproved) |

---

## 1️⃣1️⃣ Coupon & Discount Management
Admins can create discount codes.

### ✔ Functionalities
- Create coupon  
- Edit coupon  
- Delete coupon  
- Activate / Deactivate coupon  
- Apply coupon at checkout  
- Usage limit + expiry date  

### ✔ Table (coupons)
| Column | Type | Description |
|--------|------|-------------|
| coupon_id | PK |
| coupon_code | varchar |
| discount_type | Percentage / Fixed |
| discount_value | decimal |
| valid_from | datetime |
| valid_to | datetime |
| usage_limit | int |
| used | int |
| status | boolean |

---

## 🛠 Tech Stack
- **Spring Boot 3+**
- **Spring Data JPA**
- **MySQL**
- **Hibernate**
- **REST APIs**
- **Maven**
- **Postman (Testing)**

---

## 📁 Project Structure

src/main/java/com/example/demo
│
├── entities
├── repos
├── controllers
├── services (optional)
└── VibgyorEComApplication

---

## ▶ How to Run Project

### 1. Clone Repository

### 2. Import in Spring Tool Suite / IntelliJ

### 3. Update `application.properties`

### 4. Run Application

### 5. Test APIs in Postman

---

## 👤 Author
**Shantanu Dattaswami Sarad**  
Full-Stack Developer | Java | Spring Boot | MySQL

---

## ⭐ Conclusion
This project is a complete backend for an enterprise-level e-commerce platform including all major modules such as:

✔ Categories  
✔ Products  
✔ Customers  
✔ Orders  
✔ Payments  
✔ Cart  
✔ Wishlist  
✔ Shipping  
✔ Reviews  
✔ Coupons  

Perfect for internship, resume, and portfolio!

---

