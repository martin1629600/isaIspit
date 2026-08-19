package mappers;

import com.example.isa.entities.Vinyl;
import com.example.isa.models.VinylModel;

import java.util.ArrayList;
import java.util.List;

public class VinylMapper {

    public static VinylModel toModel(Vinyl entity){
        return VinylModel.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .releaseYear(entity.getReleaseYear())
                .userId(entity.getUserId())
                .genreId(entity.getGenre().getId())
                .artistId(entity.getArtist().getId())
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
