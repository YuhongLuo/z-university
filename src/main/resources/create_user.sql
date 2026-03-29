-- Create the user if it doesn't already exist
CREATE USER IF NOT EXISTS 'reststudentuser'@'localhost' IDENTIFIED BY 'zupassword';

-- Grant privileges on the schema.  Note: Ensure cs548_reststudentdb exists first.
GRANT ALL PRIVILEGES ON cs548_reststudentdb.* TO 'reststudentuser'@'localhost' WITH GRANT OPTION;

-- Refresh privileges
FLUSH PRIVILEGES;

-- Show grants to verify
SHOW GRANTS FOR 'reststudentuser'@'localhost';
