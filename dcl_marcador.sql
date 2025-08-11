CREATE TABLE marcador (
    nombre VARCHAR(127) NOT NULL,
    tipo_marcacion ENUM('entrada', 'salida') NOT NULL,
    fecha_hora DATETIME NOT NULL,
    feCreacion DATE NULL COMMENT 'Fecha de creación',
	usrCreacion varchar(127) NULL COMMENT 'Usuario de creación',
	estado varchar(15) NULL COMMENT 'Estado de la tabla admi_pais',
	feUltModificacion DATE NULL COMMENT 'Fecha de última modificación',
	usrUltModificacion varchar(15) NULL COMMENT 'Usuario de última modificación'
);