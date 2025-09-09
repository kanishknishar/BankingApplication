# Banking Application

Interactive Java console application demonstrating knowledge of Collections Framework through hierarchical banking system management.

## Features

- **Branch Management**: Add branches, view all locations
- **Customer Management**: Register customers per branch with initial deposits
- **Transaction Processing**: Record and view customer transaction history
- **Comprehensive Reporting**: List all branches, customers, and transactions with Roman numeral indexing

## Technical Implementation

**Architecture:**
- `Bank` - Static utility class managing all branches
- `Branch` - Contains customers list and branch operations
- `Customer` - Manages individual transaction history
- `Main` - Interactive console interface
- `RomanNumerals` - Enum-based Roman numeral conversion

## Interactive Menu Options
1. View all branches and customers (with optional transaction details)
2. List all branches
3. View specific branch customers
4. Add new branch
5. Add customer to branch
6. Record customer transaction
7. Exit

## Key Features

- **Input Validation**: Prevents duplicate branches/customers
- **Error Handling**: Graceful handling of invalid operations
- **Hierarchical Display**: Roman numerals for customer indexing
- **Transaction History**: Complete audit trail per customer
- **Interactive UX**: Clear prompts and feedback

Demonstrates proficiency with nested collections, object relationships, and console-based user interaction patterns.