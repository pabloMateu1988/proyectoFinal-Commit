ALTER TABLE `colegio`.`persona_cursos` 
DROP FOREIGN KEY `FKkmplu0m8kbog8ofs3cciqr7ya`;
ALTER TABLE `colegio`.`persona_cursos` 
CHANGE COLUMN `docente_id` `docente_id` BIGINT NULL ,
CHANGE COLUMN `alumno_id` `alumno_id` BIGINT NULL ;
ALTER TABLE `colegio`.`persona_cursos` 
ADD CONSTRAINT `FKkmplu0m8kbog8ofs3cciqr7ya`
  FOREIGN KEY (`docente_id`)
  REFERENCES `colegio`.`persona` (`id`);