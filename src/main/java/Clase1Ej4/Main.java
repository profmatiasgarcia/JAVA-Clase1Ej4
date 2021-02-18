package Clase1Ej4;
/**
 * @author Prof Matias Garcia.
 * <p> Copyright (C) 2017 para <a href = "https://www.profmatiasgarcia.com.ar/"> www.profmatiasgarcia.com.ar </a>
 * - con licencia GNU GPL3.
 * <p> Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo los términos de la
 * Licencia Pública General de GNU según es publicada por la Free Software Foundation, 
 * bien con la versión 3 de dicha Licencia o bien (según su elección) con cualquier versión posterior. 
 * Este programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA, 
 * incluso sin la garantía MERCANTIL implícita o sin garantizar la CONVENIENCIA PARA UN PROPÓSITO
 * PARTICULAR. Véase la Licencia Pública General de GNU para más detalles.
 * Debería haber recibido una copia de la Licencia Pública General junto con este programa. 
 * Si no ha sido así ingrese a <a href = "http://www.gnu.org/licenses/"> GNU org </a>
 */

import java.util.Scanner;
public class Main {

    /** EJEMPLO VECTORES EN JAVA */
    
    public static void main(String[] args) {
        final int NALUMNOS = 10; // constante
        float notas[] = new float[NALUMNOS]; // array notas
        int i; // índice
        float suma = 0; // suma total de todas las notas medias
        Scanner sc = new Scanner(System.in); // objeto para lectura por teclado
        System.out.println("INICIO");
        // Entrada de datos
        for (i = 0; i < NALUMNOS; i++) {
            System.out.println("Alumno número " + (i + 1) + " nota media: ");
            float valor = sc.nextFloat(); // variable que guarda lectura de
            // float por teclado
            notas[i] = valor;
        }

        // Sumar las notas
        for (i = 0; i < NALUMNOS; i++) {
            suma += notas[i];
        }

        // Escribir resultados
        System.out.println("\n Nota media del curso: " + (suma / NALUMNOS));

        /********************************/
        
        Scanner lectura = new Scanner(System.in);
        int[] a = new int[10];
        int[] b = new int[10];
        int[] c = new int[20];// vector union
        int[] aib = new int[10];
        int k, aux, cc = 0, cia = 0, cib = 0, pg = 0, n, m;

        // entrada de datos
        System.out.println("Introduzca el tamanio de los vectores: ");
        n = lectura.nextInt();
        m = n;
        System.out.println();
        System.out.println("Introduzca los datos del primer vector(1-10): ");
        for (i = 0; i < n; i++) {
            a[i] = lectura.nextInt();
        }
        System.out.println("Introduzca los datos del segundo vector(1-10): ");
        for (int f = 0; f < m; f++) {
            b[f] = lectura.nextInt();
        }

        // Ordena el vector a
        k = n / 2;
        while (k > 0) {
            for (int x = 0; x < n; x++) {
                if ((k + x) <= (n - 1)) {
                    if (a[x] > a[x + k]) {
                        aux = a[x + k];
                        a[x + k] = a[x];
                        a[x] = aux;
                        cc = cc + 1;
                    }
                }
            }
            if (cc == 0) {
                k = (int) (k / 2);
            }
            cc = 0;
        }
        // Ordena el vector b
        k = m / 2;
        while (k > 0) {
            for (int x = 0; x < m; x++) {
                if ((k + x) <= (m - 1)) {
                    if (b[x] > b[x + k]) {
                        aux = b[x + k];
                        b[x + k] = b[x];
                        b[x] = aux;
                        cc = cc + 1;
                    }
                }
            }
            if (cc == 0) {
                k = (int) (k / 2);
            }
            cc = 0;
        }
        // Union de los vectores, elementos repetidos no son parte
        pg = 0;
        for (int nb = 0; nb < n + m; nb++) {
            c[nb] = 0;
        }
        for (i = 0; i < n; i++) {
            for (int nb = 0; nb < n + m; nb++) {
                if (a[i] == c[nb]) {
                    cia++;
                }
            }
            if (cia == 0) {
                c[pg] = a[i];
                cia = 0;
                pg = pg + 1;
            } else {
                cia = 0;
            }
        }
        for (i = 0; i < m; i++) {
            for (int nb = 0; nb < n + m; nb++) {
                if (b[i] == c[nb]) {
                    cib++;
                }
            }
            if (cib == 0) {
                c[pg] = b[i];
                cib = 0;
                pg = pg + 1;
            } else {
                cib = 0;
            }
        }

        // mostrar vectores
        System.out.println("Los vectores son: ");
        for (int f = 0; f < n; f++) {
            System.out.print(a[f] + " ");
        }
        System.out.println("");
        for (i = 0; i < m; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        System.out.print("Union: ");
        for (i = 0; i < pg; i++) {
            System.out.print(c[i] + " ");
        }
        int p = 0;
        System.out.println();

        // obtiene y muestra la interseccion
        for (i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] == b[j]) {
                    aib[p] = b[j];
                    p++;
                } // contador de elementos en la interseccion
            }
        }
        if (p == 0) {
            System.out.print("No existen elementos comunes");
        } else {
            System.out.print("Interseccion de A y B: ");
            for (i = 0; i < p; i++) {
                System.out.print(aib[i] + " ");
            }
        }
        System.out.println();

        // Diferencia A-B las diferencias se basan en las interseccion
        System.out.print("A-B: ");
        int y = 0;
        for (i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                if (a[i] == aib[j]) {
                    y++;
                }
            }
            if (y == 0) {
                System.out.print(a[i] + " ");
            }
            y = 0;
        }
        System.out.println();

        // Diferencia B-A
        System.out.print("B-A: ");
        y = 0;
        for (i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                if (b[i] == aib[j]) {
                    y++;
                }
            }
            if (y == 0) {
                System.out.print(b[i] + " ");
            }
            y = 0;
        }
    }
}
