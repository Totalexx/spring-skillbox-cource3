CREATE TABLE IF NOT EXISTS contacts (
    id UUID PRIMARY KEY,
    firstName VARCHAR(100),
    lastName VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100)
);