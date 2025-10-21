-- Asignaturas
INSERT INTO asignaturas (id, codigo, nombre) VALUES (1, 'CAL01', 'Cálculo I');
INSERT INTO asignaturas (id, codigo, nombre) VALUES (2, 'MEC01', 'Mecánica');
INSERT INTO asignaturas (id, codigo, nombre) VALUES (3, 'POO01', 'Programación Orientada a Objetos');
INSERT INTO asignaturas (id, codigo, nombre) VALUES (4, 'BD01', 'Bases de datos I');
INSERT INTO asignaturas (id, codigo, nombre) VALUES (5, 'EST01', 'Estadística');

-- Oficinas
INSERT INTO oficinas (id, nombre, ubicacion) VALUES (1, 'Oficina 101', 'Edificio 1');
INSERT INTO oficinas (id, nombre, ubicacion) VALUES (2, 'Oficina 102', 'Edificio 1');
INSERT INTO oficinas (id, nombre, ubicacion) VALUES (3, 'Oficina 103', 'Edificio 1');
INSERT INTO oficinas (id, nombre, ubicacion) VALUES (4, 'Oficina 104', 'Edificio 1');

-- Personas (base para Docentes y Administrativos)
INSERT INTO personas (id, nombres, apellidos, correo) VALUES (1, 'Hernán', 'Cortes', 'hcortes@unicauca.edu.co');
INSERT INTO personas (id, nombres, apellidos, correo) VALUES (2, 'Henry', 'Martínez', 'hmartinez@unicauca.edu.co');
INSERT INTO personas (id, nombres, apellidos, correo) VALUES (3, 'Carolina', 'López', 'clopez@unicauca.edu.co');
INSERT INTO personas (id, nombres, apellidos, correo) VALUES (4, 'Carlos', 'Ruiz', 'carlosruiz@unicauca.edu.co');
INSERT INTO personas (id, nombres, apellidos, correo) VALUES (5, 'Sofía', 'Moreno', 'sofmoreno@unicauca.edu.co');
INSERT INTO personas (id, nombres, apellidos, correo) VALUES (6, 'Daniel', 'Rodriguez', 'drodriguez@unicauca.edu.co');

-- Administrativos (heredan de Persona)
INSERT INTO administrativos (idAdministrativo, rol) VALUES (5, 'Secretario');
INSERT INTO administrativos (idAdministrativo, rol) VALUES (6, 'Coordinador');

-- Docentes (heredan de Persona)
INSERT INTO docentes (idDocente, idOficina) VALUES (1, 1);
INSERT INTO docentes (idDocente, idOficina) VALUES (2, 2);
INSERT INTO docentes (idDocente, idOficina) VALUES (3, 3);
INSERT INTO docentes (idDocente, idOficina) VALUES (4, 4);

-- Espacios Físicos
INSERT INTO espaciosfisicos (id, nombre, capacidad, estado, ubicacion) VALUES (1, 'Sala 2', 25, 1, 'FIET');
INSERT INTO espaciosfisicos (id, nombre, capacidad, estado, ubicacion) VALUES (2, 'Salón 230', 35, 1, 'FIET');
INSERT INTO espaciosfisicos (id, nombre, capacidad, estado, ubicacion) VALUES (3, 'Auditorio Gregorio Caicedo', 30, 1, 'F-CIVIL');
INSERT INTO espaciosfisicos (id, nombre, capacidad, estado, ubicacion) VALUES (4, 'Sala 4', 25, 1, 'FIET');
INSERT INTO espaciosfisicos (id, nombre, capacidad, estado, ubicacion) VALUES (5, 'Salón 227', 30, 1, 'FIET');

-- Cursos
INSERT INTO cursos (id, nombre, idAsignatura) VALUES (1, 'Cálculo I - Grupo A', 1);
INSERT INTO cursos (id, nombre, idAsignatura) VALUES (2, 'Mecánica - Grupo A', 2);
INSERT INTO cursos (id, nombre, idAsignatura) VALUES (3, 'Programación Orientada a Objetos - Grupo A', 3);
INSERT INTO cursos (id, nombre, idAsignatura) VALUES (4, 'Programación Orientada a Objetos - Grupo B', 3);
INSERT INTO cursos (id, nombre, idAsignatura) VALUES (5, 'Bases de Datos I - Grupo A', 4);

-- Franjas Horarias
INSERT INTO franjashorarias (id, dia, horaInicio, horaFin, idEspacioFisico, idCurso) VALUES (1, 'Lunes', '09:00:00', '11:00:00', 2, 1);
INSERT INTO franjashorarias (id, dia, horaInicio, horaFin, idEspacioFisico, idCurso) VALUES (2, 'Martes', '09:00:00', '11:00:00', 4, 2);
INSERT INTO franjashorarias (id, dia, horaInicio, horaFin, idEspacioFisico, idCurso) VALUES (3, 'Lunes', '11:00:00', '13:00:00', 3, 3);

-- Relación Docente-Curso (tabla intermedia DocenteCurso)
INSERT INTO cursodocente (idDocente, idCurso) VALUES (1, 1);
INSERT INTO cursodocente (idDocente, idCurso) VALUES (2, 2);
INSERT INTO cursodocente (idDocente, idCurso) VALUES (3, 3);
INSERT INTO cursodocente (idDocente, idCurso) VALUES (4, 3);