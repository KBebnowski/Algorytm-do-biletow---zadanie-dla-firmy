/*
// You want to buy public transport tickets for the upcoming month. You know exactly the days on which you will be traveling.
// The month has 30 days and there are three types of ticket:
// - 1-one dat ticket, costs 2, valid for one day
// - 7-day ticket, costs 7, valid for seven consecutive days (first valid day is X, then the last valid day is X+6)
// - 30-day ticket, costs 25, valid for all thirty days of the month
// You want to pay as little as possible
//
// You are given sorted (in increassing order) array A of dates when you will be traveling. For example given:
// A[0] = 1
// A[1] = 2
// A[2] = 4
// A[3] = 5
// A[4] = 7
// A[5] = 29
// A[6] = 30
// you can buy one 7-day ticket and two 1-day tickets. The two 1-day tickets should be used on days 29 and 30. The 7-day ticket should be used on
// the first seven days of the month. The total cost is 11 and there is no possible way of paying less.
//
// Write a function
// public int solution (int[] A))
// that, given an array A consisting of N integers that specifies days on which you will be traveling, returns the minimum amount of money
// that you have to spend on tickets for the month.
//
// For example, given the above data, the function should return 11, as explained above
// Assume that:
// N is integer within the range [0...30]
// each element of array A is an integer within the range [1...30]
// array A is sorted in increassing order
// the elements of A are all distinct
//
// Created by Kamil Bębnowski 01.10.2019r.
*/

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

class TransportTicket
{
    // ALGORYTM
    // Mniej niz 4 dni pod rzad --> 1 dniowy
    // 4, lub wiecej dni pod rzad --> 7 dniowy
    // Cena wieksza niz 25 --> 30 dniowy

    public int solution(int[] A) {

        int i = 0;                                      //ZMIENNA OKRESLAJACA POZYCJE W TABELI
        int amount =0;                                  //SUMA CENY BILETOW
        while(i<31) {
//WARUNEK SPRAWDZAJACY DNI, PONIZEJ 25 DNIA.
            if (i < 25) {
                if ((A[i + 6] - A[i]) == 6) {           //(PONIEWAZ A[i+6] WYRZUCA BLAD zastosowano podzial na dni)
                    amount += 7;
                    i += 7;
                }
                else if (((A[i + 5] - A[i]) == 6) ||((A[i + 5] - A[i]) == 5))  {
                    amount += 7;
                    i += 6;
                }
                else if (((A[i + 4] - A[i]) == 6) ||((A[i + 4] - A[i]) == 5) ||((A[i + 4] - A[i]) == 4)) {
                    amount += 7;
                    i += 5;
                }
                else if (((A[i + 3] - A[i]) == 6) ||((A[i + 3] - A[i]) == 5)||((A[i + 3] - A[i]) == 4)||((A[i + 3] - A[i]) == 3)) {
                    amount += 7;
                    i += 4;
                }
                else if (A[i] != 0) {
                    amount += 2;
                    i++;
                } else {
                    i++;
                }
            }
//PONIZEJ 26 DNIA
            else if (i < 26) {
                if (((A[i + 5] - A[i]) == 6) ||((A[i + 5] - A[i]) == 5))  {
                    amount += 7;
                    i += 6;
                }
                else if (((A[i + 4] - A[i]) == 6) ||((A[i + 4] - A[i]) == 5) ||((A[i + 4] - A[i]) == 4)) {
                    amount += 7;
                    i += 5;
                }
                else if (((A[i + 3] - A[i]) == 6) ||((A[i + 3] - A[i]) == 5)||((A[i + 3] - A[i]) == 4)||((A[i + 3] - A[i]) == 3)) {
                    amount += 7;
                    i += 4;
                }
                else if (A[i] != 0) {
                    amount += 2;
                    i++;
                } else {
                    i++;
                }
            }
//PONIZEJ 27 DNIA
            else if (i < 27) {
                if (((A[i + 4] - A[i]) == 6) ||((A[i + 4] - A[i]) == 5) ||((A[i + 4] - A[i]) == 4)) {
                    amount += 7;
                    i += 5;
                }
                else if (((A[i + 3] - A[i]) == 6) ||((A[i + 3] - A[i]) == 5)||((A[i + 3] - A[i]) == 4)||((A[i + 3] - A[i]) == 3)) {
                    amount += 7;
                    i += 4;
                }
                else if (A[i] != 0) {
                    amount += 2;
                    i++;
                } else {
                    i++;
                }
            }
//PONIZEJ 28 DNIA
            else if (i < 28) {
                if (((A[i + 3] - A[i]) == 6) ||((A[i + 3] - A[i]) == 5)||((A[i + 3] - A[i]) == 4)||((A[i + 3] - A[i]) == 3)) {
                    amount += 7;
                    i += 4;
                }
                else if (A[i] != 0) {
                    amount += 2;
                    i++;
                } else {
                    i++;
                }
            }
//pomijamy ponizej 29 i 30 dnia, poniewaz nie uwzgledniamy juz 7 dniowych biletow, poniewaz sa nieoplacalne
            else if(i<31) {
                if (A[i] != 0) {
                    amount += 2;
                    i++;
                } else {
                    i++;
                }
            }
        }
//jesli koszt wynosi 25 $ lub wiecej to oplaca sie kupic bilet 30 dniowy
        if (amount>=25)
        {
            return 25;
        }
        else {
            return amount;
        }
    }

    public static void main(String args[])
    {

        //TWORZENIE TABLICY
        int[]tab = new int [31];

        //PRZYPISANIE DNI DO ELEMENTOW TABLICY
        tab[0]=1;
        tab[1]=2;
        tab[2]=3;
        tab[3]=4;
        tab[4]=8;
        tab[5]=9;
        tab[6]=10;
        tab[7]=11;
        tab[8]=15;
        tab[9]=16;
        tab[10]=17;
        tab[11]=18;
        /*tab[12]=22;
        tab[13]=23;
        tab[14]=24;
        tab[15]=25;
        tab[16]=26;
        tab[17]=27;*/
        tab[17]=29;
        // tab[18]=30;

        TransportTicket transportTicket = new TransportTicket();
        System.out.println(transportTicket.solution(tab));       //WYSWIETLENIE NAJBARDZIEJ PRZYSTEPNEJ CENY
    }
}