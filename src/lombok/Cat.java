package lombok;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Cat {
    @Getter
    private String name;
    @NonNull
    private int age;

}
