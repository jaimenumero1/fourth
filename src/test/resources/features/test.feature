Feature: test test class

  Scenario: Empty a table from a database
    Given a connection to a database is started
    When you remove all records from a "employees" table
    Then employees table should be empty

