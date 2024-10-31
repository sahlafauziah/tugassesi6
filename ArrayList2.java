import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

class ArrayListBuah{
    String nama;
    int harga;

    ArrayListBuah(String nama, int harga){
        this.nama = nama;
        this.harga = harga;
    }

    int getHarga(int jumlah){
        if (this.nama.equalsIgnoreCase("Mangga") && jumlah == 1) {
            return 10000;
        }
        return this.harga;
    }
}

class ArrayListItem{
    ArrayListBuah buah;
    int jumlah;

    ArrayListItem(ArrayListBuah buah, int jumlah){
        this.buah = buah;
        this.jumlah = jumlah;
    }

    int getSubtotal(){
        return buah.getHarga(jumlah) * jumlah;
    }

    int getHargaPerItem(){
        return buah.getHarga(jumlah);
    }
}

public class ArrayList2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        ArrayList<ArrayListBuah> daftarBuah = new ArrayList<>();

        daftarBuah.add(new ArrayListBuah("Apel", 35000));
        daftarBuah.add(new ArrayListBuah("Jeruk", 50000));
        daftarBuah.add(new ArrayListBuah("Mangga", 25000));
        daftarBuah.add(new ArrayListBuah("Duku", 15000));
        daftarBuah.add(new ArrayListBuah("Semangka", 20000));

        ArrayList<ArrayListItem> keranjang = new ArrayList<>();
        int pilihan;

        do{
            System.out.println("Menu : ");
            System.out.println("1. Beli Buah");
            System.out.println("2. Lihat Struk");
            System.out.println("3. Keluar");
            System.out.print("Masukan Pilihan : ");
            pilihan = scanner.nextInt();

            if (pilihan == 1) {
                String lanjut;
                do{
                    System.out.println("Pilih buah (0-4) : ");
                    for(int i =0; i < daftarBuah.size(); i++){
                        System.out.printf("%-3d %-10s Rp%-10d\n",
                        i, daftarBuah.get(i).nama, daftarBuah.get(i).harga);        
                    }

                    System.out.print("Masukan pilihan buah : ");
                    int pilihanBuah = scanner.nextInt();
                    System.out.print("Masukan jumlah : ");
                    int jumlah = scanner.nextInt();

                    keranjang.add(new ArrayListItem(daftarBuah.get(pilihanBuah), jumlah));

                    System.out.print("Input lagi? (y/n): ");
                    lanjut = scanner.next();

                } while (lanjut.equalsIgnoreCase("y"));

            } else if (pilihan == 2) {
                if (keranjang.isEmpty()) {
                    System.out.println("Keranjang anda masih kosong");
                } else{
                    System.out.println("Daftar belanjaan anda : ");
                    System.out.println("============================");
                    System.out.printf("%-3s %-10s %-3s %-10s %-10s\n",
                                    "No" ,"Nama", "Jumlah", "Harga", "Subtotal");

                    int totalHarga = 0;

                    for(int i = 0; i < keranjang.size(); i++){
                        ArrayListItem item = keranjang.get(i);
                        System.out.printf("%-3d %-10s %-3d %-10d %-10d\n",
                                        (i + 1),item.buah.nama,item.jumlah,item.getHargaPerItem(),item.getSubtotal());
                    totalHarga += item.getSubtotal();
                    }
                    
                    System.out.println("============================");
                    System.out.println("Total Harga : " + totalHarga);

                    double diskon = totalHarga * 15 / 100;
                    double totalBayar = totalHarga - diskon;
                    System.out.println("Diskon (15%) Rp." +diskon);
                    System.out.println("Total bayar Rp." + totalBayar);
                    System.out.println("============================");
                }
            } else if (pilihan != 3) {
                System.out.println("Pilihan tidak valid.");
            }
        }while (pilihan != 3);
        System.out.println("Terima kasih sudah berbelanja!");
        scanner.close();
    }
}

