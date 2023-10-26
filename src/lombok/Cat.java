package lombok;

@NoArgsConstructor  //создаст конструктор по умолчанию
@AllArgsConstructor //создаст конструктор с параметрами
@RequiredArgsConstructor  // создаст конструктор с каким-то параметром
@Data   //создаст геттеры и сеттеры
@ToString
@EqualsAndHashCode
public class Cat {
    @Getter // создаст геттер только конкретного поля
    private String name;
    @NonNull  // для указания поля для конструктора с каким-то параметром
    private int age;


}
