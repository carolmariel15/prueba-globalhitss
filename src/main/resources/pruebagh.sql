DROP TABLE tb_producto;
CREATE TABLE tb_producto
(
id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) PRIMARY KEY,
nombre VARCHAR2(100), 
fech_registro DATE
);

SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE SP_REGISTRAR_PRODUCTO(v_id NUMBER, v_nombre IN VARCHAR2)
AS
BEGIN
    INSERT INTO tb_producto VALUES (v_id, v_nombre, trunc(sysdate));
    DBMS_OUTPUT.PUT_LINE('Registro insertados  : '||SQL%ROWCOUNT);
    COMMIT;
END;

SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE SP_LISTAR_PRODUCTOS
AS
    v_fecha DATE := trunc(sysdate);
BEGIN
    SELECT * FROM tb_producto p WHERE p.fech_registro = v_fecha;
END;

EXECUTE SP_REGISTRAR_PRODUCTO(1,"PRODUCTO 1");
