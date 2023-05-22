#Data Validator

### Hexlet tests and linter status:
[![Actions Status](https://github.com/MaksimDenisov/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/MaksimDenisov/java-project-78/actions)

### Code Climate
[![Maintainability](https://api.codeclimate.com/v1/badges/07ea0d9f852dac207c12/maintainability)](https://codeclimate.com/github/MaksimDenisov/java-project-78/maintainability)

[![Test Coverage](https://api.codeclimate.com/v1/badges/07ea0d9f852dac207c12/test_coverage)](https://codeclimate.com/github/MaksimDenisov/java-project-78/test_coverage)

To use a validator, you need to create a validator object and take one of the three data validation schemes.
- **StringSchema** is used for string validation.
- **NumberSchema** is used for numbers validation.
- **MapSchema** is used for checking associative arrays.

The necessary restrictions are set on the selected scheme.
Next, you need to call the **isValid()** method on the configured schema and pass the checked data to it.
The result will be a boolean value of true if the data has passed verification, or false if it has not.

### Available restrictions.

#### StringSchema
- **required()** — adds a constraint to the schema that does not allow using null or an empty string as a value
- **minLength()** — adds a minimum length constraint for a string. The string must be equal to or longer than the specified number.
- **contains()** — adds a restriction on the contents of the string. The string must contain a specific substring.

#### NumberSchema

- **required()** — adds a constraint to the schema that does not allow using null as a value
- **positive()** — adds a restriction on the sign of a number. The number must be positive
- **range()** — adds a valid range in which the value of the number should fall, including the boundaries

#### MapSchema
- **required()** — adds a constraint to the schema that does not allow null to be used as a value.
- **sizeof()** data type is required — adds a limit on the size of the dictionary. The number of key-value pairs in the Map object must be equal to the specified.
- **shape()** is used to define the properties of a Map object and create a schema to validate their values. A set of constraints is assigned to each property.