# Automation Testing Project for SauceDemo.com

## Deskripsi Proyek
Proyek ini bertujuan untuk mengotomatisasi pengujian pada platform e-commerce SauceDemo. Pengujian dilakukan untuk memastikan alur kerja utama seperti login, menambahkan produk ke keranjang, dan proses checkout berjalan dengan baik. Proyek ini menggunakan Selenium WebDriver dan TestNG untuk menciptakan pengujian yang efektif, efisien, dan mudah dikelola.

## Teknologi yang Digunakan
1. Selenium WebDriver: Untuk mengotomatisasi interaksi dengan elemen web.
2. TestNG: Untuk eksekusi, prioritas, dan pelaporan hasil tes.
3. GitHub: Untuk manajemen versi dan kolaborasi.
4. Google Sheets: Untuk dokumentasi skenario pengujian.

## Fitur Proyek
1. Kasus Uji Positif: Validasi checkout berhasil dengan data pengguna dan pengiriman yang valid.
2. Kasus Uji Negatif:
   1. Menampilkan pesan kesalahan ketika kolom wajib (misalnya, nama depan) kosong.
   2. Memastikan sistem menangani kode pos yang tidak valid.
3. Penggunaan Dynamic Waits: Mengatasi elemen yang lambat dimuat menggunakan explicit wait.
4. Penerapan Page Object Model (POM): Membuat kode lebih rapi dan mudah dipelihara.

## Dokumentasi
1. Dokumentasi Skenario Pengujian:
   * Google Spreadsheet [https://docs.google.com/spreadsheets/d/1CazrO7Qu3xayESIDd0HI_B6zRUOtbbvg4OY-KOcvR2U/edit?usp=sharing]
   * Gambar
        * LoginTest ==> ![image](https://github.com/user-attachments/assets/62b93b48-92a8-4d0a-90df-94cfc605111f)


## Hasil Utama
Semua pengujian positif dan negatif berhasil sesuai harapan.
Struktur kode yang modular dan dapat digunakan kembali melalui penerapan POM.

## Cara Menjalankan Proyek

### Clone repositori:
```git clone https://github.com/tautan-repository-anda```
* Buka proyek di IntelliJ IDEA atau editor lain.
* Pastikan dependencies di ```pom.xml``` sudah terpasang dengan benar.
* Jalankan pengujian menggunakan perintah:
```mvn test```
* Cek laporan hasil pengujian yang dihasilkan oleh TestNG.


# Tentang Penulis
## Erick Damora
### Quality Assurance Tester | Automation Engineer
