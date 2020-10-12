package com.codecool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name="reservations")
public class Reservation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "renter_id")
    private Long appUserId;
    @CreationTimestamp
    private Date rentingStartDate;
    @CreationTimestamp
    private Date rentingEndDate;

    public Reservation() {
    }

    public Reservation(Long id, Long itemId, Long appUserId, Date rentingStartDate, Date rentingEndDate) {
        this.id = id;
        this.itemId = itemId;
        this.appUserId = appUserId;
        this.rentingStartDate = rentingStartDate;
        this.rentingEndDate = rentingEndDate;
    }

    public static final class Builder {
        private Long id;
        private Long itemId;
        private Long appUserId;
        private Date rentingStartDate;
        private Date rentingEndDate;

        public Reservation.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Reservation.Builder itemId(Long itemId) {
            this.itemId = itemId;
            return this;
        }

        public Reservation.Builder appUserId(Long appUserId) {
            this.appUserId = appUserId;
            return this;
        }

        public Reservation.Builder rentingStartDate(Date rentingStartDate) {
            this.rentingStartDate = rentingStartDate;
            return this;
        }

        public Reservation.Builder rentingEndDate(Date rentingEndDate) {
            this.rentingEndDate = rentingEndDate;
            return this;
        }

        public Reservation build() {
            Reservation reservation = new Reservation();
            reservation.id = this.id;
            reservation.itemId = this.itemId;
            reservation.appUserId = this.appUserId;
            reservation.rentingStartDate = this.rentingStartDate;
            reservation.rentingEndDate = this.rentingEndDate;

            return reservation;
        }
    }
}
