mvn clean test
allure generate allure-results --clean -o allure-report
mkdir -p allure-results/history && cp -r allure-report/history/* allure-results/history/ || true
allure serve