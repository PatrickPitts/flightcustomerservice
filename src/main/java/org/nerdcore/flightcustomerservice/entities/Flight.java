package org.nerdcore.flightcustomerservice.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Flights")
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date departureDate;

    @Temporal(TemporalType.DATE)
    private Date arrivalDate;

    @NotBlank
    private String departureCity;

    @NotBlank
    private String arrivalCity;

    @NotBlank
    private String departureState;

    @NotBlank
    private String arrivalState;

    @NotBlank
    private String departureAirportCode;

    @NotBlank
    private String arrivalAirportCode;

    @Column(columnDefinition = "INTEGER default 0")
    private int numFirstClassSeats;

    @Column(columnDefinition = "INTEGER default 0")
    private int numBusinessClassSeats;

    public Flight(Date departureDate, Date arrivalDate, @NotBlank String departureCity, @NotBlank String arrivalCity, @NotBlank String departureState, @NotBlank String arrivalState, @NotBlank String departureAirportCode, @NotBlank String arrivalAirportCode, int numFirstClassSeats, int numBusinessClassSeats) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureState = departureState;
        this.arrivalState = arrivalState;
        this.departureAirportCode = departureAirportCode;
        this.arrivalAirportCode = arrivalAirportCode;
        this.numFirstClassSeats = numFirstClassSeats;
        this.numBusinessClassSeats = numBusinessClassSeats;
    }

    public Flight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureState() {
        return departureState;
    }

    public void setDepartureState(String departureState) {
        this.departureState = departureState;
    }

    public String getArrivalState() {
        return arrivalState;
    }

    public void setArrivalState(String arrivalState) {
        this.arrivalState = arrivalState;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public int getNumFirstClassSeats() {
        return numFirstClassSeats;
    }

    public void setNumFirstClassSeats(int numFirstClassSeats) {
        this.numFirstClassSeats = numFirstClassSeats;
    }

    public int getNumBusinessClassSeats() {
        return numBusinessClassSeats;
    }

    public void setNumBusinessClassSeats(int numBusinessClassSeats) {
        this.numBusinessClassSeats = numBusinessClassSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                departureDate.equals(flight.departureDate) &&
                arrivalDate.equals(flight.arrivalDate) &&
                departureCity.equals(flight.departureCity) &&
                arrivalCity.equals(flight.arrivalCity) &&
                departureState.equals(flight.departureState) &&
                arrivalState.equals(flight.arrivalState) &&
                departureAirportCode.equals(flight.departureAirportCode) &&
                arrivalAirportCode.equals(flight.arrivalAirportCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departureDate, arrivalDate, departureCity, arrivalCity, departureState, arrivalState, departureAirportCode, arrivalAirportCode);
    }
}
