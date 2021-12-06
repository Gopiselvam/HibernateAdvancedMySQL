**Hibernate Advanced concepts**
1. Identifier generation strategy
2. Composite primary key
3. Association mapping: Many to one
4. Association mapping: Many to Many
5. Inheritance mapping
6. Criteria API
7. Hibernate Caching
8. Hibernate Envers
9. Hibernate Events
10. Interceptors

**Java Tech stacks**
- Excel sheet to Java Object conversion (eg: NativeIncrementStrategy, CriteriaAPI)
- JSON to java Object conversion (eg: compositPrimaryKey)
- Java reflections. Getting the field names
- java LocalDate parsing
- Generating Random Long numbers
- ALTER TABLE customer AUTO_INCREMENT = 1001; to start the primary key from 1001
- log4j.properties with Loggers

**Advice**
- use "\\|" while splitting pipelines instead of "|"
- Always remember to implement Serializable for Composit primary keys
- use session.persist() if you are using CascadeType.PERSIST
- copy paste variable names from code wherever createQuery method is used.
- Make sure REVINFO, REV column is AUTO_INCREMENT. (HibernateEnvers)