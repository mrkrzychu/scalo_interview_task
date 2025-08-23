# scalo_interview_task

# Requirements

Java 17 or Java 21 installed
(check with java -version)

Maven installed and added to PATH
(check with mvn -v)

Internet connection (Playwright will download the required browsers)

# Clone the repository

git clone <git@github.com:mrkrzychu/scalo_interview_task.git>

cd <scalo_interview_task>

# Install dependencies

mvn clean install

# Run the application

mvn exec:java

# Example output

Selected city: Wrocław
Current temperature: 17.6°C

# Notes

The list of cities is stored in src/main/resources/cities.txt