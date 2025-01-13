DO
$create_role_prog_role$
    BEGIN
        IF EXISTS (
            SELECT FROM pg_catalog.pg_roles WHERE  rolname = 'prog_role') THEN
            RAISE NOTICE 'Role "prog_role" already exists. Skipping.';
        ELSE
            CREATE ROLE prog_role LOGIN PASSWORD '123456';
        END IF;
    END
$create_role_prog_role$;

GRANT ALL PRIVILEGES ON DATABASE hei TO prog_role;
ALTER DEFAULT PRIVILEGES FOR ROLE prog_role
    GRANT ALL PRIVILEGES ON TABLES TO prog_role;
ALTER DEFAULT PRIVILEGES FOR ROLE prog_role
    GRANT ALL PRIVILEGES ON SEQUENCES TO prog_role;
GRANT ALL PRIVILEGES ON SCHEMA public TO prog_role;
\c hei prog_role