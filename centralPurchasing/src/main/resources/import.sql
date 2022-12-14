
INSERT INTO NationalStock(id)
VALUES
    (1);

INSERT INTO Quantity(quantity)
VALUES
    (100),
    (100),
    (100);

INSERT INTO NationalProduct (nationalstock_id,name, price, type, quantity_id)
VALUES
    (1,"avocado",0.89,"fruit",1),
    (1,"beef",6.99,"meat",2),
    (1,"cucumber",8.99,"vegetable",3);

