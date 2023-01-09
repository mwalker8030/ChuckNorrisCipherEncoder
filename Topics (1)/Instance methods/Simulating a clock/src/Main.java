class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        // implement me

        minutes++;
        if(minutes > 59) {
            minutes = 0;
            ++hours;
            if(hours > 12) {
                hours = 1;
            }
        }
    }
}