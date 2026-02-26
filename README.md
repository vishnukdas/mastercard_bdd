# Mastercard Selenium Cucumber BDD

Basic Selenium + Cucumber BDD project that runs on LambdaTest using RemoteWebDriver.

## Setup

Set these environment variables before running tests:

- `LT_USERNAME` and `LT_ACCESS_KEY` (required)
- `LT_PLATFORM` (default: `Windows 11`)
- `LT_BROWSER_VERSION` (default: `latest`)
- `LT_BUILD` (default: `mastercard-demo`)
- `LT_GRID_URL` (default: `https://%s:%s@hub.lambdatest.com/wd/hub`)
- `BASE_URL` (default: `https://www.mastercard.com`)

## Run

```
mvn test
```

## Allure (API tests)

Run only API scenarios and generate Allure results:

```
mvn test -Dcucumber.filter.tags="@api"
```

Then serve the report locally (requires Allure CLI):

```
allure serve target/allure-results
```
