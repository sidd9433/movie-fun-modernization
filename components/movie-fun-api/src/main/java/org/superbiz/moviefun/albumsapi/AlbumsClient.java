package org.superbiz.moviefun.albumsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.List;

public class AlbumsClient {

    private String albumsUrl;
    private RestOperations restOperations;

    public AlbumsClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    private static ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };

    public void addAlbum(AlbumInfo album) {
        restOperations.postForEntity(albumsUrl, album, AlbumInfo.class);
    }

    public AlbumInfo find(long id) {
        return restOperations.getForObject(albumsUrl + "/" + id, AlbumInfo.class);
    }

    public List<AlbumInfo> getAlbums() {
        return restOperations.exchange(albumsUrl, HttpMethod.GET, null, albumListType).getBody();
    }

    public void deleteAlbum(long id) {
        restOperations.delete(albumsUrl + "/" + id);
    }

    public void updateAlbum(AlbumInfo album) {
        restOperations.put(albumsUrl, album);
    }
}
