package org.gerdoc.pixup.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ReadUtil
{
    private Scanner scanner;
    private static ReadUtil readUtil;

    private ReadUtil()
    {
        scanner = new Scanner( System.in );
    }

    public Scanner getScanner()
    {
        return scanner;
    }

    public static ReadUtil getInstance( )
    {
        if(readUtil==null)
        {
            readUtil = new ReadUtil();
        }
        return readUtil;
    }

    public static String read( )
    {
        return getInstance( ).getScanner( ).nextLine();
    }

    public static Integer readInt( )
    {
        String valor = null;
        boolean flag = true;
        Integer aux = null;

        while (flag)
        {
            valor = read();
            if (valor != null && !valor.isEmpty())
            {
                try
                {
                    aux = Integer.valueOf(valor);
                    if (aux != null)
                    {
                        return aux;
                    }
                }
                catch (Exception e)
                {
                    System.out.println(" Numero Invalido ");
                }
            }
        }
        return null;
    }

    public static Float readFloat() {
        String valor;
        while (true) {
            valor = read();
            try {
                return Float.valueOf(valor);
            } catch (NumberFormatException e) {
                System.out.print(" Numero Invalido ");
            }
        }
    }

    public static LocalDate readLocalDate() {
        String valor;
        while (true) {
            valor = read();
            try {
                return LocalDate.parse(valor);
            } catch (NumberFormatException e) {
                System.out.print(" Fecha invalida ");
            }
        }
    }

    public static LocalTime readLocalTime() {
        String valor;
        while (true) {
            valor = read();
            try {
                return LocalTime.parse(valor);
            } catch (NumberFormatException e) {
                System.out.print("Tiempo invalido ");
            }
        }
    }
}