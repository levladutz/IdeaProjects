package com.company;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class UTest {

    // Your tests
    @Test
    void TestAddress(){
        Address a = new Address("Pacuari", 61, "549", "Isi");
        Address b = new Address("Pacurari", 61, "549", "Iasi");
        assertEquals(a,b);
    }

}

