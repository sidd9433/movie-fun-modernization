package org.superbiz.moviefun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.superbiz.moviefun.albumsapi.AlbumsClient;
import org.superbiz.moviefun.albumsapi.CoverCatalog;
import org.superbiz.moviefun.blobstore.BlobStore;
import org.superbiz.moviefun.moviesapi.MoviesClient;

@Configuration
public class ClientConfiguration {

    @Bean
    public AlbumsClient albumsClient(RestOperations restOperations) {
        return new AlbumsClient("//album-service/albums", restOperations);
    }

    @Bean
    public MoviesClient moviesClient(RestOperations restOperations) {
        return new MoviesClient("//movie-service/movies", restOperations);
    }

    @Bean
    public CoverCatalog coverCatalog(BlobStore blobStore) {
        return new CoverCatalog(blobStore);
    }
}
