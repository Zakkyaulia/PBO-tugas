import java.util.InputMismatchException;
import java.util.Scanner;

// Kelas Barang
class Barang {
    private String kode; // Kode barang
    private String nama; // Nama barang
    private double harga; // Harga barang

    public Barang(String kode, String nama, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}

// Kelas Transaksi yang mewarisi Barang
class Transaksi extends Barang {
    private int noFaktur; // Nomor faktur transaksi
    private int jumlahBeli; // Jumlah barang yang dibeli
    private double total; // Total harga

    public Transaksi(int noFaktur, String kode, String nama, double harga, int jumlahBeli) {
        super(kode, nama, harga); // Memanggil konstruktor Barang
        this.noFaktur = noFaktur;
        this.jumlahBeli = jumlahBeli;
        this.total = harga * jumlahBeli; // Menghitung total
    }

    public int getNoFaktur() {
        return noFaktur;
    }

    public int getJumlahBeli() {
        return jumlahBeli;
    }

    public double getTotal() {
        return total;
    }

    public void cetakTransaksi() {
        System.out.println("No Faktur: " + noFaktur);
        System.out.println("Kode Barang: " + getKode());
        System.out.println("Nama Barang: " + getNama());
        System.out.println("Harga Barang: " + getHarga());
        System.out.println("Jumlah Beli: " + jumlahBeli);
        System.out.println("Total: " + total);
    }
}

// Kelas utama untuk menjalankan program
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ulang = true;

        while (ulang) {
            try {
                // Input No Faktur
                System.out.print("Masukkan No Faktur: ");
                int noFaktur = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            
                // Input Kode Barang
                System.out.print("Masukkan Kode Barang: ");
                String kodeBarang = scanner.nextLine();
            
                // Input Nama Barang
                System.out.print("Masukkan Nama Barang: ");
                String namaBarang = scanner.nextLine();
            
                // Input Harga Barang
                System.out.print("Masukkan Harga Barang: ");
                double hargaBarang = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
            
                // Input Jumlah Beli
                System.out.print("Masukkan Jumlah Beli: ");
                int jumlahBeli = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            
                // Membuat objek Transaksi (sekaligus menggunakan inheritance)
                Transaksi transaksi = new Transaksi(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);
            
                // Mencetak detail transaksi
                transaksi.cetakTransaksi();
            
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Silakan masukkan data yang benar.");
                
                // Clear the invalid input
                scanner.nextLine(); // Clear the invalid input
            }
            
            // Menanyakan apakah ingin mencoba memasukkan transaksi lagi
            System.out.print("Apakah Anda ingin mencoba memasukkan transaksi lagi? (iya/tidak): ");
            String jawab = scanner.nextLine();
            ulang = jawab.equalsIgnoreCase("iya");
        }
        
        scanner.close(); // Menutup scanner setelah selesai
        System.out.println("Terima kasih telah menggunakan program ini.");
    }
}
