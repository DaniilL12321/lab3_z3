class Item{
    int d;//ключ
    Item next;
    Item prev;
    //конструктор:
    Item(int value){
        d=value;
    }
}
class List{
    private Item pbeg=null;//указатель на начало списка
    private Item pend=null;//указатель на конец списка
    //поиск элемента списка по ключю
    Item find(int value){
        Item pv=pbeg;//установка на начало списка
        while(pv!=null){
            if(pv.d==value) break;//если нашли элемент, то выйти из списка
            pv=pv.next;//переход к следующему элементу списка
        }
        return pv;
    }
    //Вставка в начало списка:
    void insert(int value){
        Item insertion =new Item(value);
        if (pbeg==null){//если список пустой
            pbeg=insertion;
            pend=pbeg;
            // System.out.print(pbeg.d+" ");
        }else {
            insertion.next=pbeg;
            pbeg.prev=insertion;
            pbeg=insertion;
        }

    }
    //Добавление в конец списка
    void append(int value){
        Item insertion=new Item(value);
        if (pend==null){//если список пустой
            pend=insertion;
            pbeg=pend;
        }else {
            pend.next=insertion;
            insertion.prev=pend;
            pend=insertion;
        }
    }
    //Вывод списка на печать
    void printList(){
        Item pv=pbeg;//установка списка на начало
        while (pv!=null){
            System.out.println(pv.d+" ");
            pv=pv.next;
        }
    }

    // Метод определения, является ли список пустым
    boolean isEmpty() {
        return pbeg == null;
    }

    // Метод подсчета количества элементов с равными "соседями"
    int countEqualNeighbors() {
        int count = 0;
        Item pv = pbeg; // Установка на начало списка
        while (pv != null) {
            if (pv.prev != null && pv.next != null && pv.prev.d == pv.next.d) {
                count++;
            }
            pv = pv.next; // Переход к следующему элементу списка
        }
        return count;
    }
}

public class z3 {
    public static void main(String[] args) {
        List spisok = new List();
        spisok.append(1);
        spisok.append(2);
        spisok.append(5);
        spisok.append(2);
        spisok.append(3);
        spisok.printList();


        // Проверка метода isEmpty
        System.out.println("Является ли список пустым: " + spisok.isEmpty());

        // Подсчет количества элементов с равными "соседями"
        System.out.println("Количество элементов с равными соседями: " + spisok.countEqualNeighbors());
    }
}
