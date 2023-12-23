CREATE TABLE commande
(
    id          INT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    date      Date NOT NULL,
    quantite      int NOT NULL,
    montant        double          NOT NULL,
    product_id  int not null
);