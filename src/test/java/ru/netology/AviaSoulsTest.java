package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {
    public Ticket ticket1 = new Ticket("Москва", "Саратов", 20_000, 10, 15);
    public Ticket ticket2 = new Ticket("Москва", "Воронеж", 15_000, 11, 14);
    public Ticket ticket3 = new Ticket("Москва", "Саратов", 14_000, 12, 15);
    public Ticket ticket4 = new Ticket("Москва", "Воронеж", 20_000, 9, 10);
    public Ticket ticket5 = new Ticket("Москва", "Саратов", 21_000, 14, 18);

    @Test
    void compareTo() {
        Assertions.assertEquals(0, ticket1.compareTo(ticket4));
        Assertions.assertEquals(1, ticket5.compareTo(ticket1));
        Assertions.assertEquals(-1, ticket3.compareTo(ticket2));
    }

    @Test
    void sort() {
        AviaSouls sorting = new AviaSouls();
        sorting.add(ticket1);
        sorting.add(ticket2);
        sorting.add(ticket3);
        sorting.add(ticket4);
        sorting.add(ticket5);

        assertArrayEquals(new Ticket[]{ticket3, ticket1, ticket5},
                sorting.search("Москва", "Саратов"));
    }

    @Test
    void comparatorTime() {
        AviaSouls sorting = new AviaSouls();
        sorting.add(ticket1);
        sorting.add(ticket2);
        sorting.add(ticket3);
        sorting.add(ticket4);
        sorting.add(ticket5);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Assertions.assertEquals(1, comparator.compare(ticket1, ticket2));
        Assertions.assertEquals(-1, comparator.compare(ticket4, ticket5));
        Assertions.assertEquals(0, comparator.compare(ticket2, ticket3));
    }

    @Test
    void comparatorTimeSort() {
        AviaSouls sorting = new AviaSouls();
        sorting.add(ticket1);
        sorting.add(ticket2);
        sorting.add(ticket3);
        sorting.add(ticket4);
        sorting.add(ticket5);
        Ticket[] tickets = sorting.findAll();

        sorting.searchAndSortBy();

        assertArrayEquals(new Ticket[]{ticket4, ticket2, ticket3, ticket5, ticket1}, tickets);
    }

    @Test
    void searchTimeFromTo() {
        AviaSouls sorting = new AviaSouls();
        sorting.add(ticket1);
        sorting.add(ticket2);
        sorting.add(ticket3);
        sorting.add(ticket4);
        sorting.add(ticket5);

        sorting.searchAndSortBy();
        Ticket[] tickets = sorting.findAll();

        assertArrayEquals(new Ticket[]{ticket4, ticket2, ticket3, ticket5, ticket1}, tickets);
    }
}