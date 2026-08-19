package mappers;

import com.example.isa.entities.Genre;
import com.example.isa.entities.Vinyl;
import com.example.isa.models.VinylModel;
import com.example.isa.models.VinylPageModel;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class VinylMapper {

    public static VinylModel toModel(Vinyl entity){
        return VinylModel.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .releaseYear(entity.getReleaseYear())
                .genreNames(
                        entity.getGenres()
                                .stream()
                                .map(Genre::getName)
                                .toList()
                )
                .artistName(entity.getArtist().getName())
                .available(entity.isAvailable())
                .rentedUntil(entity.getRentedUntil())
                .build();
    }

    public static VinylPageModel toModelPagedList(Page<Vinyl> pageEntity){
        return VinylPageModel.builder()
                .totalElements(pageEntity.getTotalElements())
                .totalPages(pageEntity.getTotalPages())
                .vinyls(toModelList(pageEntity.getContent()))
                .build();
    }

    public static List<VinylModel> toModelList(List<Vinyl> entities){
        var list = new ArrayList<VinylModel>();

        for(var entity : entities){
            list.add(toModel(entity));
        }

        return list;
    }
}
