import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {MediaModel} from "../../../models/media.model";
import {Store} from "@ngrx/store";
import {loadMedias} from "../../../state/media/media-actions";
import {selectAllMedias} from "../../../state/media/media-selector";

@Component({
  selector: 'app-media',
  templateUrl: './media.component.html',
  styleUrls: ['./media.component.css']
})
export class MediaComponent implements OnInit{
  mediasChild:MediaModel[]=[]
  @Output() mediasSend:EventEmitter<MediaModel[]>=new EventEmitter<MediaModel[]>();

   medias!:MediaModel[];



  constructor(private store:Store) {

    store.dispatch(loadMedias({medias:this.medias}))
  }
  ngOnInit() {
    this.store.select(selectAllMedias).subscribe(
      medias =>{
      this.medias =medias
      }
    )
  }

  getMedias(medias:MediaModel){
    if (this.mediasChild.includes(medias)){

    }else{
      this.mediasChild.push(medias)
      console.log(this.mediasChild)
    }

    this.mediasSend.emit(this.mediasChild)
  }

}
