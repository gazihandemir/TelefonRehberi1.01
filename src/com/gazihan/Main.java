package com.gazihan;

import java.util.Scanner;

public class Main {


   /* -> regberine kişi ekleyebilme ,sorgulayabilme,kişi silip güncelleyebilmeli

      -> Bir kişi eklenirken veya güncellenirken o kişinin olup olmadıgı kontrol edilir

      -> Telefon menüsünde çıkış,tüüm kişileri listeleme,yeni kişi ekleme,kişi güncelle ve kişi sil olmalı

       MENU methodu :

       private static void menuyuGöster(){
        System.out.println("********************MENU***************************");
        System.out.println("0 -- Çıkış\n" +
                "1 -- Tüm Kişileri Listele \n" +
                "2 -- Yeni Kişi Ekle \n" +
                "3 -- Kişi sorgula \n" +
                "4 --  Kişi Sil\n" +
                "5 -- Kişiyi Güncelle\n"+
                "6 -- Menüyü göster");
    }

  */

    private static  Scanner veri = new Scanner(System.in);
    private static CepTelefonu cepTelefonu = new CepTelefonu("0507 406 1199 ");
    public static void main(String[] args) {

        telefonuBaslat();
        menuyuGöster();
        boolean cikis = false;
        while(!cikis){
            System.err.println("Menüyü görmek icin 6 ya basiniz"); // err yazılışı hatadan dolayı degil, kırmızı ve dikkat çekici gözükmesi içindir
            int secim = veri.nextInt();
            switch (secim){
                case 0:
                    System.out.println("cikis yapılıyor...");
                    cikis = true;
                    break;
                case 1:
                    cepTelefonu.tumRehber(); break;
                case 2:
                    yeniKisiEkleMethodu(); break;
                case 3 :
                    kisiSorgulaMethodu(); break;
                case 4 :
                    kisiSilMethodu(); break;
                case 5:
                    kisiGücellemeMethodu(); break;
                case 6:
                    menuyuGöster();
                    break;
                default:
                    System.out.println("düzgün bir seçim yapınız ");
            }
        }
    }

    private static void kisiGücellemeMethodu() {
        System.out.println("güncellencek kisinin adi : ");
        String isim = veri.next();
        Kisi bulunanKisi = cepTelefonu.kisiSorgula(isim);
        if(bulunanKisi == null) {
            System.out.println("kayıt bulunamadi ");
            return;
        }
        System.out.println("yeni isim degeri : ");
        String yeniİsim=veri.next();
        System.out.println("yeni tel degeri :");
        String yeniTelNo=veri.next();
        cepTelefonu.kisiGücelle(bulunanKisi,Kisi.olustur(yeniİsim,yeniTelNo));


    }

    private static void kisiSilMethodu() {
        System.out.println("silinecek kişinin adi : ");
        String isim = veri.next();
        Kisi buluanaKisi = cepTelefonu.kisiSorgula(isim);
        if(cepTelefonu.kisiSil(buluanaKisi)){
            System.out.println("silme işlemi yapıldı ");

        }

    }

    private static void kisiSorgulaMethodu() {
        System.out.println("aranacak kişi adını giriniz");
        String isim = veri.next();

        Kisi bulunanKisi =cepTelefonu.kisiSorgula(isim);
        if(bulunanKisi == null){
            System.out.println(isim+" isminde bir kayıt yoktur ");
            return;
        }
        System.out.println("bulunan kisi : "+bulunanKisi.getIsim()+" ->   "+bulunanKisi.getTelNo());
    }

    private static void yeniKisiEkleMethodu() {
        System.out.println("yeni kişinin adi : ");
        String isim = veri.next();
        System.out.println("yeni kisinin telefonu : ");
        String telefon = veri.next();
        Kisi yeni = Kisi.olustur(isim,telefon);
        cepTelefonu.ekleYeniKisi(Kisi.olustur(isim,telefon));
    }

    private static void telefonuBaslat() {
        System.out.println("telefon başlatıldı ");
    }

    private static void menuyuGöster(){
        System.out.println("********************MENU***************************");
        System.out.println("0 -- Çıkış\n" +
                "1 -- Tüm Kişileri Listele \n" +
                "2 -- Yeni Kişi Ekle \n" +
                "3 -- Kişi sorgula \n" +
                "4 --  Kişi Sil\n" +
                "5 -- Kişiyi Güncelle\n"+
                "6 -- Menüyü göster");
    }




























}
