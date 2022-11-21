package ru.netology;

public class Main {
    public static void main(String[] args) {

        ProductRepository repo = new ProductRepository();

        try {
            repo.findById(5);

        } catch (NotFoundException e) {
            System.out.println("Element with id not found");
        }}}


