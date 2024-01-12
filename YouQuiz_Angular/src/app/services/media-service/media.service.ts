import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MediaModel} from "../../models/media.model";


@Injectable({
  providedIn: 'root'
})
export class MediaService {
  baseUrl="http://localhost:8080/api/media"
  constructor(private http:HttpClient) { }


  getMedias(){
   return  this.http.get<MediaModel[]>(this.baseUrl);
  }

  addMedia(media:MediaModel){
    return this.http.post<MediaModel>(this.baseUrl,media)
  }

  deleteMedia(id:number){
    return this.http.delete(this.baseUrl+`/${id}`)
  }
}
