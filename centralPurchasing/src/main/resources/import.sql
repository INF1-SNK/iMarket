INSERT INTO Product (nationalstock_id,name, price, type)
VALUES
    (1,"avocado",0.89,"fruit"),
    (1,"guinea fowl",6.99,"meat"),
    (1,"salmon",8.99,"fish");

INSERT INTO NationalStock(id)
VALUES
    (1);

INSERT INTO NationalStock_Product(product_id, nationalstock_id, quantity)
VALUES
    (1,1,100),
    (1,2,100),
    (1,3,100);