# Allo-Bank Project

Hi, I'm Dan Eliezer, the creator of this repository. This guide will help you run the project successfully.

## Prerequisites

* Java 17
* Maven 3.4.12
* IDE: IntelliJ IDEA (recommended) or others like NetBeans, Eclipse

## Clone the Repository

1. Copy the repository URL from this branch (Click **Code → HTTPS → Copy URL**).
2. Open your project folder, then open Git Bash or Command Prompt.
3. Run the command:

   ```bash
   git clone -b master https://github.com/Eliezerya/feat/idr-rate-aggregator.git
   ```
4. Wait until the project is cloned successfully.

## Open Project

1. Open the project in your IDE (project name: `allo-bank`).
2. Wait for Maven to resolve dependencies. If needed, refresh Maven manually:

   * In IntelliJ IDEA, click **Maven** on the right sidebar → click the **Refresh** icon (cycle).

## Run Project

1. Locate the `AlloBankApplication` class.
2. Click **Run** or **Start** to launch the application.

## Optional: Run from Terminal

You can also run the project without an IDE:

```bash
mvn clean install
mvn spring-boot:run
```

## How to test API
note: before test API you should check your project running 
1. you can try API by using Postman or other tools
2. add request in postman and set Method to **GET**
3. then paste this api
- http://localhost:8082/api/finance/data/latest_idr_rates
- curl -X GET http://localhost:8082/api/finance/data/latest_idr_rates
response :
{
    "resourceType": "latest_idr_rates",
    "data": {
        "amount": 1.0,
        "base": "IDR",
        "date": "2025-11-20",
        "rates": {
            "AUD": 9.2E-5,
            "BGN": 1.0E-4,
            "BRL": 3.2E-4,
            "CAD": 8.4E-5,
            "CHF": 4.8E-5,
            "CNY": 4.2E-4,
            "CZK": 0.00125,
            "DKK": 3.9E-4,
            "EUR": 5.2E-5,
            "GBP": 4.6E-5,
            "HKD": 4.6E-4,
            "HUF": 0.01983,
            "ILS": 1.9E-4,
            "INR": 0.0053,
            "ISK": 0.00761,
            "JPY": 0.00941,
            "KRW": 0.08773,
            "MXN": 0.0011,
            "MYR": 2.5E-4,
            "NOK": 6.1E-4,
            "NZD": 1.1E-4,
            "PHP": 0.00353,
            "PLN": 2.2E-4,
            "RON": 2.6E-4,
            "SEK": 5.7E-4,
            "SGD": 7.8E-5,
            "THB": 0.00194,
            "TRY": 0.00253,
            "USD": 6.0E-5,
            "ZAR": 0.00103
        },
        "usdBuySpreadIdr": 16828.333333333336
    }
}
- http://localhost:8082/api/finance/data/historical_idr_usd
- curl -X GET http://localhost:8082/api/finance/data/historical_idr_usd
response:
{
    "resourceType": "historical_idr_usd",
    "data": {
        "amount": 1.0,
        "base": "IDR",
        "startDate": "2023-12-29",
        "endDate": "2024-01-05",
        "rates": {
            "2023-12-29": {
                "USD": 6.5E-5
            },
            "2024-01-02": {
                "USD": 6.4E-5
            },
            "2024-01-03": {
                "USD": 6.4E-5
            },
            "2024-01-04": {
                "USD": 6.4E-5
            },
            "2024-01-05": {
                "USD": 6.4E-5
            }
        }
    }
}
- http://localhost:8082/api/finance/data/supported_currencies
- curl -X GET http://localhost:8082/api/finance/data/supported_currencies
response:
{
    "resourceType": "supported_currencies",
    "data": {
        "currencies": {
            "AUD": "Australian Dollar",
            "BGN": "Bulgarian Lev",
            "BRL": "Brazilian Real",
            "CAD": "Canadian Dollar",
            "CHF": "Swiss Franc",
            "CNY": "Chinese Renminbi Yuan",
            "CZK": "Czech Koruna",
            "DKK": "Danish Krone",
            "EUR": "Euro",
            "GBP": "British Pound",
            "HKD": "Hong Kong Dollar",
            "HUF": "Hungarian Forint",
            "IDR": "Indonesian Rupiah",
            "ILS": "Israeli New Sheqel",
            "INR": "Indian Rupee",
            "ISK": "Icelandic Króna",
            "JPY": "Japanese Yen",
            "KRW": "South Korean Won",
            "MXN": "Mexican Peso",
            "MYR": "Malaysian Ringgit",
            "NOK": "Norwegian Krone",
            "NZD": "New Zealand Dollar",
            "PHP": "Philippine Peso",
            "PLN": "Polish Złoty",
            "RON": "Romanian Leu",
            "SEK": "Swedish Krona",
            "SGD": "Singapore Dollar",
            "THB": "Thai Baht",
            "TRY": "Turkish Lira",
            "USD": "United States Dollar",
            "ZAR": "South African Rand"
        }
    }
}

**Personalization**

GitHub Username: eliezerya

Spread Factor: 0.00765

This factor is applied to calculate USD_BuySpread_IDR in the latest IDR rates.


