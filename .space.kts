job("Test code") {
    gradlew("openjdk:11", "test")

    failOn {
        timeOut {
            timeOutInMinutes = 5
        }
    }
}