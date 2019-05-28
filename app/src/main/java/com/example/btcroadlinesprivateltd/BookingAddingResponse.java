package com.example.btcroadlinesprivateltd;

public class BookingAddingResponse {
    int n,ok;

    public BookingAddingResponse(int n, int ok) {
        this.n = n;
        this.ok = ok;
    }

    @Override
    public String toString() {
        return "BookingAddingResponse{" +
                "n=" + n +
                ", ok=" + ok +
                '}';
    }
}
