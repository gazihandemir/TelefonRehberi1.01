package com.gazihan;

import java.util.ArrayList;

public class CepTelefonu {

    private ArrayList<Kisi> rehber;
    private String kendiNumaram;
    public CepTelefonu(String kendiNumaram){
        this.kendiNumaram=kendiNumaram;
        this.rehber = new ArrayList<Kisi>();
    }
    public  boolean ekleYeniKisi(Kisi yeniKisi){
        if(kisiBul(yeniKisi.getIsim()) >= 0) {
            System.out.println(yeniKisi.getIsim()+ " degeri rehber de zaten var ");
            return false;
        }
        this.rehber.add(yeniKisi);
        return true;
    }
    public int kisiBul(Kisi aranacakKisi){
        return this.rehber.indexOf(aranacakKisi);

    }
    public int kisiBul(String isim){
        for(int i=0;i<this.rehber.size();i++){
            Kisi oAnkiKisiNesnesi  = this.rehber.get(i);
            if(oAnkiKisiNesnesi.getIsim().equals(isim)){
                return i;
            }
        }
        return -1;
    }
    public Kisi kisiSorgula(String isim){
        int pozisyon = kisiBul(isim);
        if(pozisyon >= 0){
            return rehber.get(pozisyon);

        }
        return null;
    }
    public void tumRehber(){
        if(this.rehber.size() != 0){
            System.out.println("\n *********************TÜM REHBER ****************************");
        }else if(this.rehber.size() == 0){
            System.out.println("******REHBER BOŞ********");
        }

        for(int i=0;i<this.rehber.size();i++){
            if(rehber.size() == 0){
                System.out.println("kayıtlı kişi yok\n\n ");
                return ;
            }
            System.out.println((i+1)+"- "+ rehber.get(i).getIsim()+ " -> "+rehber.get(i).getTelNo());
        }




    }

    public boolean kisiSil(Kisi silinecekKisi){
        int pozisyon = kisiBul(silinecekKisi);
        if(pozisyon <0 ){
            System.out.println("öyle bir bişi yok ");
            return false;
        }
        this.rehber.remove(silinecekKisi);
        return true;
    }
    public boolean kisiGücelle(Kisi eskiKisi,Kisi yeniKisi){
        int bulunanPozisyon = kisiBul(eskiKisi);
        if(bulunanPozisyon < 0){
            System.out.println("böyle bir kayıt yok ! ");
            return false;
        }
        rehber.set(bulunanPozisyon,yeniKisi);
        System.out.println(eskiKisi.getIsim()+" degeri  "+ yeniKisi.getIsim()+" ile güncellendi ");
        return true;
    }







}
