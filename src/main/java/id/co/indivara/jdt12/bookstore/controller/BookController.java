package id.co.indivara.jdt12.bookstore.controller;

import id.co.indivara.jdt12.bookstore.entity.Book;
import id.co.indivara.jdt12.bookstore.entity.BukuMahal;
import id.co.indivara.jdt12.bookstore.entity.BukuMurah;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookController {
    @GetMapping("/book/{isbn}/{judul}/{pengarang}")
    public Book tampilkanBuku(
            @PathVariable("isbn") String isbn,
            @PathVariable("judul") String judul,
            @PathVariable("pengarang") String pengarang){
        return new Book(isbn, judul, pengarang);
    }

    @PostMapping("/simpan")
    public BukuMahal simpanBuku(@RequestBody Book jsonData){
        Book b = jsonData;
        BukuMahal bm = new BukuMahal();
        bm.setIsbn(b.getIsbn());
        bm.setJudul(b.getJudul());
        bm.setPengarang(b.getPengarang());
        bm.setKemasan("Kotak Kayu");
        bm.setCover("Besi");
        return bm;
//      b.setPengarang(b.getPengarang() + "INI DARI JSON LHOO....");
//      return b;
    }
    @GetMapping("/all")
    public ArrayList<Book> findAllBook(){
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("1111","Cara Anu","Dadang"));
        list.add(new Book("2222","Cara Ana","Dudung"));
        list.add(new Book("3333","Cara Ono","Dodong"));
        return list;
    }

    @PostMapping("/termurah")
    public BukuMurah findBukuTermurah(@RequestBody ArrayList<BukuMurah> list){
        BukuMurah buku = list.get(1); //ambil element pertama yg akan kita bandingkan
        for (BukuMurah b:list){
            if(b.getHarga() < buku.getHarga()){
                buku = b;
            }
        }
        return buku;
    }
//    @GetMapping("/bookstore")
//    public Book bookstoreGet(
//            @RequestParam(value="isbn",defaultValue = "0") String isbn,
//            @RequestParam(value = "judul",defaultValue = "Laskar Pelangi") String judul,
//            @RequestParam(value = "pengarang",defaultValue = "Erlangga") String pengarang){
//        return new Book(isbn,"Judul Buku: "+judul,"pengarang: "+pengarang);
//    }
//    @PostMapping("/bookstore")
//    public Book bookstorePost(
//            @RequestParam(value="isbn",defaultValue = "0") String isbn,
//            @RequestParam(value = "judul",defaultValue = "Dunia") String judul,
//            @RequestParam(value = "pengarang",defaultValue = "Erlangga") String pengarang){
//        return new Book(isbn,"Judul Buku: "+judul,"pengarang: "+pengarang);
//    }
//    @PutMapping("/bookstore")
//    public Book bookstorePut(
//            @RequestParam(value="isbn",defaultValue = "0") String isbn,
//            @RequestParam(value = "judul",defaultValue = "Dunia") String judul,
//            @RequestParam(value = "pengarang",defaultValue = "Erlangga") String pengarang){
//        return new Book(isbn,"Judul Buku: "+judul,"pengarang: "+pengarang);
//    }
//    @PatchMapping("/bookstore")
//    public Book bookstorePatch(
//            @RequestParam(value="isbn",defaultValue = "0") String isbn,
//            @RequestParam(value = "judul",defaultValue = "Dunia") String judul,
//            @RequestParam(value = "pengarang",defaultValue = "Erlangga") String pengarang){
//        return new Book(isbn,"Judul Buku: "+judul,"pengarang: "+pengarang);
//    }
//    @DeleteMapping("/bookstore")
//    public Book bookstoreDelete(
//            @RequestParam(value="isbn",defaultValue = "0") String isbn,
//            @RequestParam(value = "judul",defaultValue = "Dunia") String judul,
//            @RequestParam(value = "pengarang",defaultValue = "Erlangga") String pengarang){
//        return new Book(isbn,"Judul Buku: "+judul,"pengarang: "+pengarang);
//    }

}
